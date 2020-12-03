import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { DocumentationService } from '../services/documentation.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-doc',
  templateUrl: './doc.component.html',
  styleUrls: ['./doc.component.styl']
})

export class DocComponent implements OnInit {
  /*
  constructor( private documentationService : DocumentationService) { }

  documentation: any[] = [];
  documentationSubject = new Subject<any[]>();



  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument





  /*  getAllDocumentation() {
    this.documentationService.getDocumentation().subscribe( 
      (data)=> {
        this.documentation = data;
        this.emitDocumentationSubject
      }, (error) => {
        console.log('probleme de chargement');
      })
  }
  */

  ngOnInit(): void {
  }

}
