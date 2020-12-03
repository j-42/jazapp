import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Doc } from '../models/doc.model';

@Injectable()
export class DocumentationService {

  constructor(private httpClient: HttpClient) { }

  documentationSubject = new Subject<any[]>();


  private documentation : Doc[] = [
    {
      "id":10,
      "permissions":"noob",
      "os":["os"],
      "langages":["langage"],
      "frameworks":["framework 1", "framework 2"],
      "libraries":["library 1", "library 2"],
      "content":"content"
    }
  ];


  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument



  addDocumentation(doc:Doc) {
    doc.id = this.documentation[(this.documentation.length - 1)].id + 1;
    this.documentation.push(doc);
    this.emitDocumentationSubject();
  }


  rootURL = '/api/';
/*
  getDocumentation() {
    return this.httpClient
      .get<any[]>(this.rootURL + '/doc/content/')
      .subscribe( 
        (response) => {
          this.documentation = response;
          this.emitDocumentationSubject();
      },
        (error) => {
          console.log('Erreur de chatgmeent de la doc.');
      })
  }
*/

  saveDoc() {
    this.httpClient
      .post(this.rootURL + 'doc/content/post/', this.documentation[0])
      .subscribe( 
        () => {
          console.log('doc enrtregistré');
        }, 
        (error) => {
          console.log('erreur de sauvegarde' + error);
      })
  }

}
