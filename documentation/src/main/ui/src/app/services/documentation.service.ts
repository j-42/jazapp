import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Doc } from '../models/doc.model';

@Injectable()
export class DocumentationService {

  rootURL = '/api/';

  constructor(private httpClient: HttpClient) { }

  documentationSubject = new Subject<any[]>();


  private documentation : Doc[] = [];
  private newDoc!: Doc ;

  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument



  addDocumentation(doc:Doc) {
    console.log(doc);
    this.newDoc = doc;
    this.emitDocumentationSubject();
  }

  getDocumentation() {
    return this.httpClient
      .get<Doc[]>(this.rootURL + '/doc/content/')
      .subscribe( 
        (response) => {
          this.documentation = response;
          this.emitDocumentationSubject();
      },
        (error) => {
          console.log('Erreur de chatgmeent de la doc.');
      })
  }


  saveDoc() {
    this.httpClient
      .post(this.rootURL + 'doc/content/post/', this.newDoc)
      .subscribe( 
        () => {
          console.log('doc enrtregistré');
        }, 
        (error) => {
          console.log('erreur de sauvegarde' + error);
      })
  }

}
