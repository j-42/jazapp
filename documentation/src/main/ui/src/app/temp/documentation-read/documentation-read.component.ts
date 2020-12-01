import { Component, ContentChildren, Input, OnDestroy, OnInit } from '@angular/core';
import { interval, Observable, Subject, Subscription } from 'rxjs';
import { DocumentationService } from '../services/documentation.service';

@Component({
  selector: 'app-documentation-read',
  templateUrl: './documentation-read.component.html',
  styleUrls: ['./documentation-read.component.styl']
})

export class DocumentationReadComponent implements OnInit, OnDestroy {

  constructor( private documentationService : DocumentationService) { }


  documentation!: any[];
  documentationSubscription!: Subscription;
  

  ngOnDestroy(): void {
    // this.counterSubscription.unsubscribe();
  }

  ngOnInit(): void {
    this.documentationSubscription = this.documentationService.documentationSubject.subscribe(
      (documentation: any[]) => {
        this.documentation = documentation;
        console.log(documentation);
      });
      this.documentationService.emitDocumentationSubject();
    }



/*
  getStatus() {
    return this.docStatus;
  }

  getAllDocumentation() {
    this.documentationService.getDocumentation().subscribe( 
      (data)=> {
        this.documentation = data;
        this.emitDocumentationSubject
      }, (error) => {
        console.log('probleme de chargement');
      })
  }



  */
  /*
  OnSwithOffOne(){
    this.documentationService.swithOffOne(this.docIndex);
  }
  OnSwithOnOne(){
    this.documentationService.swithOnOne(this.docIndex);
  }
  */

}
