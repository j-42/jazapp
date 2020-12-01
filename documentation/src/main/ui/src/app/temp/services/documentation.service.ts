import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Doc } from '../models/doc.model';

@Injectable()
export class DocumentationService {

  documentationSubject = new Subject<any[]>();


  private documentation : Doc[] = [
    {
      "id":1,
      "permissions":"noob",
      "os":["os"],
      "langage":["langage"],
      "framework":["framework"],
      "library":["library"],
      "content":"content"
    }
    ,
    {"id":2,"permissions":"noob5","os":["os5"],"langage":["langage5"],"framework":["framework5"],"library":["library5"],"content":"content5"}
    ,
    {"id":3,"permissions":"noob","os":["mac"],"langage":["<ul><li>langage 1<li>"],"framework":["spring"],"library":["<p>{{library}}</p>","<p>{{otherlibrary}}</p>"],"content":"<li>{{content}}</li>"}
    ,
    {"id":4,"permissions":"noob","os":["mac"],"langage":["<ul><li>langage 1<li>","<ul><li>langage 2<li>"],"framework":["spring"],"library":["<p>{{library}}</p>"],"content":"<li>{{content}}</li>"}
  ];


  emitDocumentationSubject() {
    this.documentationSubject.next(this.documentation.slice());
  } // La methode next force le Subject à emmettre ce qu'on lui passe en argument

  constructor(private httpClient: HttpClient) { }

  addDocumentation(doc:Doc) {
    doc.id = this.documentation[(this.documentation.length - 1)].id + 1;
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
