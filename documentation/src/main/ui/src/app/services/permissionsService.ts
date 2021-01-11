import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { Permission } from "../models/permission.model";


@Injectable()
export class PermissionsService{

    rootURL = '/api/';
    constructor (private httpCLient : HttpClient) {};

    permissions : Permission[] = [];
    permissionsSubject = new Subject<any[]>();

    emitPermissionsSubject(){
        this.permissionsSubject.next(this.permissions.slice());
    }

    addPermission(newPermission:Permission){
        this.permissions.push(newPermission);
    }

    getPermissions(){
        return this.httpCLient
        .get<any[]>(this.rootURL + '/doc/permissions/')
        .subscribe(
            (response) => {
                this.permissions = response;
                this.emitPermissionsSubject();
            },
            (error) => {
                console.log('Erreur de chargement des Permissions');
            }
        )
    }

    savePersmissions(){
        this.httpCLient
            .post(this.rootURL + 'doc/permissions/post/', this.permissions)
            .subscribe(
                () => {
                    console.log('permissions enrtregistré');
                }, 
                (error) => {
                    console.log('erreur de sauvegarde' + error);
                })
    }
}