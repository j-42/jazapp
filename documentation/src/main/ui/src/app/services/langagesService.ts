import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { Langage } from "../models/langage.model";



@Injectable()
export class LangagesService {

    rootURL = '/api/';
    constructor(private httpClient : HttpClient){};

    langages : Langage[] = [];
    langagesSubject = new Subject<any[]>();

    emitLangagesSubject(){
        this.langagesSubject.next(this.langages.slice());
    }

    addLangage(newLangage:Langage){
        this.langages.push(newLangage);
    }

    getLangages(){
        return this.httpClient
            .get<Langage[]>(this.rootURL + '/doc/langages/')
            .subscribe(
                (response) => {
                    this.langages = response;
                    this.emitLangagesSubject;
                },(error) => {
                    console.log('Erreur de chargement des langages');
                }
            ) 
    }

    saveLangages() {
        this.httpClient
            .post(this.rootURL + '/doc/langages/post/', this.langages)
            .subscribe( 
            () => {
                console.log('langages enrtregistré');
            }, 
            (error) => {
                console.log('erreur de sauvegarde' + error);
            })
    }


}