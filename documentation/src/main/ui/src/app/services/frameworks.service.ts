import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';
import { Framework } from '../models/framework.model';



@Injectable()
export class FrameworksService {

    rootURL = '/api/';
    constructor( private httpClient : HttpClient){};

    frameworksSubject = new Subject<any[]>();
    
    frameworks : Framework[] = [];


    emitFrameworksSubject() {
        this.frameworksSubject.next(this.frameworks.slice());
    }

    addFramework(framework:Framework){
        this.frameworks.push(framework);
        this.emitFrameworksSubject();
    }

    getFrameworks() {
        return this.httpClient
            .get<any[]>(this.rootURL + '/doc/frameworks/')
            .subscribe( 
                (response) => {
                  this.frameworks = response;
                  this.emitFrameworksSubject();
              },
                (error) => {
                  console.log('Erreur de chargement des frameworks.');
              })
    }        

    saveFrameworks(){
        this.httpClient
      .post(this.rootURL + 'doc/content/post/', this.frameworks)
      .subscribe( 
        () => {
          console.log('frameworks enrtregistré');
        }, 
        (error) => {
          console.log('erreur de sauvegarde des framweorks' + error);
      })
    }
}