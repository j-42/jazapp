import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Doc } from '../models/doc.model';

@Injectable()
export class DocumentationService {

  constructor(private httpClient: HttpClient) { }

  documentationSubject = new Subject<any[]>();


  public documentation : Doc[] = [];
  public doc: Doc = {
    content: "tydjj",
    frameworks: [{id: 38, name: "Java"}],
    id: 1,
    langages: [{id: 22, name: "Angular"}],
    libraries: [{id: 23, name: "GSAP"}],
    os: [{id: 24, name: "Windows"}],
    permissions: [{id: 15, name: "Noob"}]
  }


  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument



  addDocumentation(doc:Doc) {
    console.log(doc);
    this.documentation.push(doc);
    this.emitDocumentationSubject();
    
  }


  rootURL = '/api/';

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


  saveDoc() {
    this.httpClient
      .post(this.rootURL + 'doc/content/post/', this.doc)
      .subscribe( 
        () => {
          console.log('doc enrtregistré');
        }, 
        (error) => {
          console.log('erreur de sauvegarde' + error);
      })
  }

}
