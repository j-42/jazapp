import {
  Component,
  OnInit
} from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import {
  Router
} from '@angular/router';
import {
  Doc
} from '../models/doc.model';
import {
  DocumentationService
} from '../services/documentation.service';

@Component({
  selector: 'app-edit-documentation',
  templateUrl: './documentation-create.component.html',
  styleUrls: ['./documentation-create.component.styl']
})

export class DocumentationCreateComponent implements OnInit {

  docForm!: FormGroup;




  permissions = ["noob", "good"];
  os = ["Windows", "Linux", "Mac"];
  langage = ["java", "javascript", "css"];
  framework = ["spring", "angular"];
  library = ["Google Maps", "Mustache", "Open Street"];

  constructor(private formBuilder: FormBuilder, private documentationService: DocumentationService, private router: Router) {}

  ngOnInit(): void {
      this.initForm();
  }

  initForm() {
      this.docForm = this.formBuilder.group({
          permissions: ['', Validators.required],
          os: [''],
          langage: [''],
          framework: [''],
          library: [''],
          content: ['', Validators.required]
      });
  }

  onSubmitDoc() {
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

  // Add OS
  addOs = false;
  newOs!: string;

  onAddOsInput() {
      this.addOs = true;
  }

  onAddOs() {
      this.os.push(this.newOs);
      this.newOs = "";
      this.addOs = false;
  }

  // Add Langage
  addLangage = false;
  newLangage!: string;

  onAddLangagekInput() {
      this.addLangage = true;
  }

  onAddLangage() {
      this.os.push(this.newLangage);
      this.newLangage = "";
      this.addLangage = false;
  }

  // Add Framework
  addFramework = false;
  newFramework!: string;

  onAddFrameworkInput() {
      this.addFramework = true;
  }

  onAddFramework() {
      this.os.push(this.newFramework);
      this.newFramework = "";
      this.addFramework = false;
  }

  // Add Library
  addLibrary = false;
  newLibrary!: string;

  onAddLibraryInput() {
      this.addLangage = true;
  }

  onAddLibrary() {
      this.os.push(this.newLibrary);
      this.newLibrary = "";
      this.addLibrary = false;
  }
}