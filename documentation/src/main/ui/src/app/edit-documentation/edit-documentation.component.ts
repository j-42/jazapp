import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { DocumentationService } from '../services/documentation.service';

@Component({
  selector: 'app-edit-documentation',
  templateUrl: './edit-documentation.component.html',
  styleUrls: ['./edit-documentation.component.styl']
})

export class EditDocumentationComponent implements OnInit {

  constructor(private documentationService:DocumentationService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    console.log(form.value);

    const permissions = form.value['permissions'];
    const os = form.value['os'];
    const langage = form.value['langage'];
    const framework = form.value['framework'];
    const library = form.value['library'];
    const content = form.value['content'];

    this.documentationService.addDocumentation(permissions,os,langage,framework,library,content);
    this.router.navigate(['/documentation']);
  }
}