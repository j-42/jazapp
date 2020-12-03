import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, NgForm, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Doc } from '../models/doc.model';
import { DocumentationService } from '../services/documentation.service';

@Component({
  selector: 'app-edit-documentation',
  templateUrl: './documentation-create.component.html',
  styleUrls: ['./documentation-create.component.styl']
})

export class DocumentationCreateComponent implements OnInit {

  docForm!: FormGroup;

  os = ["Windows", "Linux", "Mac"];
  permissions = ["noob", "good"];
  langage = ["java", "javascript","css"];
  framework = ["spring", "angular"];
  library = ["Google Maps", "Mustache", "Open Street"];

  constructor(private formBuilder:FormBuilder, private documentationService:DocumentationService, private router : Router) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm(){
    this.docForm = this.formBuilder.group({
      permissions: ['', Validators.required], 
      os:this.formBuilder.array([]),
      langage:this.formBuilder.array([]),
      framework:this.formBuilder.array([]),
      library:this.formBuilder.array([]),
      content: ['', Validators.required]
    });
  }

  onSubmitDoc(){
    const formValue = this.docForm.value;
    const newDoc = new Doc(
      1, 
      formValue["permissions"],
      formValue["os"] ? formValue["os"] : [],
      formValue["langage"] ? formValue["langage"] : [],
      formValue["framework"] ? formValue["framework"] : [],
      formValue["library"] ? formValue["library"] : [],
      formValue["content"]
    )
    this.documentationService.addDocumentation(newDoc);
    this.router.navigate(['/documentation']);
  }

  getOs(){
    return this.docForm.get('os') as FormArray;
  }

  onAddOs() {
    const newOs = this.formBuilder.control('');
    this.getOs().push(newOs);
  }

  getFormValidationErrors() {
    Object.keys(this.docForm.controls).forEach(key => {
  
    const controlErrors: ValidationErrors = this.docForm.get(key).errors;
    if (controlErrors != null) {
          Object.keys(controlErrors).forEach(keyError => {
            console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
          });
        }
      });
    }


}