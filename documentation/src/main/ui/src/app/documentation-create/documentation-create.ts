import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Doc} from '../models/doc.model';
import {DocumentationService} from '../services/documentation.service';
import { FrameworksService } from '../services/frameworks.service';
import { LangagesService } from '../services/langagesService';
import { LibrariesService } from '../services/LibrariesService';
import { OsService } from '../services/os.service';
import { PermissionsService } from '../services/permissionsService';

@Component({
  selector: 'app-edit-documentation',
  templateUrl: './documentation-create.component.html',
  styleUrls: ['./documentation-create.component.styl']
})

export class DocumentationCreateComponent implements OnInit {

  docForm!: FormGroup;

  permissions = this.permissionsService.permissions;
  os = this.osService.os;
  langages = this.langagesService.langages;
  frameworks = this.frameworksService.frameworks;
  libraries = this.librariesService.libraries;


  constructor(
      private formBuilder: FormBuilder, 
      private documentationService: DocumentationService, 
      private frameworksService: FrameworksService, 
      private permissionsService: PermissionsService,
      private osService: OsService,
      private langagesService: LangagesService,
      private librariesService: LibrariesService,
      private router: Router) {}



  ngOnInit(): void {
    this.frameworksService.getFrameworks();

    this.initForm();
        
  }

  initForm() {
      this.docForm = this.formBuilder.group({
          permissions: ['', Validators.required],
          os: [''],
          langages: [''],
          frameworks: [''],
          libraries: [''],
          content: ['', Validators.required]
      });
  }

  onSubmitDoc() {
      const formValue = this.docForm.value;
      const newDoc = new Doc(
          5,
          formValue["permission"],
          formValue["os"] ? formValue["os"] : [],
          formValue["langages"] ? formValue["langages"] : [],
          formValue["frameworks"] ? formValue["frameworks"] : [],
          formValue["libraries"] ? formValue["libraries"] : [],
          formValue["content"]
      )
    console.log("newDoc " + newDoc);
    this.documentationService.addDocumentation(newDoc);
    this.documentationService.saveDoc();
    this.router.navigate(["documentation"]);
  }




  // Add OS
  addOs = false;
  newOs!: string;

  onAddOsInput() {
      this.addOs = true;
  }

  onAddOs() {
      this.langages.push({id: this.langages.length -1, name:this.newOs});
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
      this.os.push({id: this.os.length -1, name:this.newFramework});
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
      this.frameworksService.addFramework({id: this.frameworksService.frameworks.length -1, name:this.newFramework});
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
      this.libraries.push({id: this.libraries.length -1, name:this.newLibrary});
      this.newLibrary = "";
      this.addLibrary = false;
  }
}