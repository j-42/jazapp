import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { Library } from "../models/library.model";



@Injectable()
export class LibrariesService {

    rootURL = '/api/';
    constructor(private httpClient:HttpClient){};

    libraries : Library[] = [];
    librariesSubject = new Subject<any[]>();

    emitLibrariesSubject(){
        this.librariesSubject.next(this.libraries.slice());
    }

    addLibrary(newLibrary:Library){
        this.libraries.push(newLibrary);
    }

    getLibraries(){
        this.httpClient
        .get<Library[]>(this.rootURL + '/doc/libraries/')
        .subscribe(
            (response) =>  {
                this.libraries = response;
                this.emitLibrariesSubject();
            },
            (error) => {
                console.log('Erreur de chargement des Permissions');
            }
        )
    }

    saveLibrary() {
        this.httpClient
            .post(this.rootURL + '/doc/libraries/', this.libraries)
            .subscribe(
            () => { 
                console.log('libraries enrtregistré');
            }, 
            (error) => {
                console.log('erreur de sauvegarde' + error);
            })
    }

}