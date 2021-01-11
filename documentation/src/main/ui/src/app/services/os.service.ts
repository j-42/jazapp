import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { Os } from '../models/os.model';




@Injectable()
export class OsService{

    rootURL = '/api/';

    constructor(private httpClient : HttpClient){};

    os : Os[] = [];
    osSubject = new Subject<any[]>();

    emitOsSubject() {
        this.osSubject.next(this.os.slice());
    } 

    addOs(newOs:Os){
        this.os.push(newOs);
    }

    getOs(){
        return this.httpClient
            .get<Os[]>(this.rootURL + '/doc/os/')
            .subscribe(
                (response) => {
                    this.os = response;
                    this.emitOsSubject();
                },
                (error) => {
                    console.log('Erreur de chargement des Os');
                }
            ) 
    }

    saveOs() {
        this.httpClient
            .post(this.rootURL + '/doc/os/post/', this.os)
            .subscribe( 
            () => {
                console.log('os enrtregistré');
            }, 
            (error) => {
                console.log('erreur de sauvegarde' + error);
            })
    }


}