import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable()
export class DocumentationService {

  documentationSubject = new Subject<any[]>();


  private documentation = [
    {
      "id":1,
      "permissions":"noob",
      "os":"os",
      "langage":"langage",
      "framework":"framework",
      "library":"library",
      "content":"content"
    }
    ,
    {"id":2,"permissions":"noob5","os":"os5","langage":"langage5","framework":"framework5","library":"library5","content":"content5"}
    ,
    {"id":3,"permissions":"noob","os":"mac","langage":"<ul><li>langage 1<li>","framework":"spring","library":"<p>{{library}}</p>","content":"<li>{{content}}</li>"}
    ,
    {"id":4,"permissions":"noob","os":"mac","langage":"<ul><li>langage 1<li>","framework":"spring","library":"<p>{{library}}</p>","content":"<li>{{content}}</li>"}
  ];


  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument

  constructor(private httpClient: HttpClient) { }

  addDocumentation(permissions:string,os:string, langage:string, framework:string, library:string, content:string) {
    
    const doc = {
      id: 0,
      permissions: "",
      os: "", 
      langage: "", 
      framework:"", 
      library: "", 
      content: ""
    }

    doc.id = this.documentation[(this.documentation.length - 1)].id + 1;
    doc.permissions = permissions;
    doc.os = os;
    doc.langage = langage;
    doc.framework = framework;
    doc.library = library;
    doc.content = content;

    this.documentation.push(doc);
    this.emitDocumentationSubject();
  }

/*
  rootURL = '/api';

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

  addDocumentation(documentation: any, id: number) {
	  documentation.id = id;
    return this.httpClient
      .put(this.rootURL + '/doc', documentation)
      .subscribe( () => {
        console.log('doc enrtregistré');
      }, (error) => {
        console.log('erreur de sauvegarde' + error);
      })
  }
*/


}
