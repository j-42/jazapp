import {
    Component,
    OnInit
} from '@angular/core';
import {
    FormBuilder,
    FormGroup,
    Validators
} from '@angular/forms';
import {
    Router
} from '@angular/router';
import { Subscription } from 'rxjs';
import {
    Doc
} from '../models/doc.model';
import {
    DocumentationService
} from '../services/documentation.service';
import {
    FrameworksService
} from '../services/frameworks.service';
import {
    LangagesService
} from '../services/langagesService';
import {
    LibrariesService
} from '../services/LibrariesService';
import {
    OsService
} from '../services/os.service';
import {
    PermissionsService
} from '../services/permissionsService';

@Component({
    selector: 'app-edit-documentation',
    templateUrl: './documentation-create.component.html',
    styleUrls: ['./documentation-create.component.styl']
})

export class DocumentationCreateComponent implements OnInit {

    docForm!: FormGroup;

     permissions = this.permissionsService.permissions;
    private permissionsSubscription!: Subscription;

     os = this.osService.os;
    private osSubscription!: Subscription;

     langages = this.langagesService.langages;
    private langagesSubscription!: Subscription;

     frameworks = this.frameworksService.frameworks;
    private frameworksSubscription!: Subscription;

     libraries = this.librariesService.libraries;
    private librariesSubscription!: Subscription;


    constructor(
        private formBuilder: FormBuilder,
        private permissionsService: PermissionsService,
        private osService: OsService,
        private langagesService: LangagesService,
        private frameworksService: FrameworksService,
        private librariesService: LibrariesService,
        private documentationService: DocumentationService,
        private router: Router) {}

    ngOnInit(): void {

        this.permissionsService.getPermissions();
        this.permissionsSubscription = this.permissionsService.permissionsSubject.subscribe(
            (permissions: any[]) => {
                this.permissions = permissions;
            });
        // this.permissionsService.emitPermissionsSubject();

        
        this.osService.getOs();
        this.osSubscription = this.osService.osSubject.subscribe(
            (os: any[]) => {
                this.os = os;
            });
        // this.permissionsService.emitPermissionsSubject();


        this.langagesService.getLangages();

        this.langagesSubscription = this.langagesService.langagesSubject.subscribe(
            (langages: any[]) => {
                console.log("langages");
                this.langages = langages;
                console.log(langages);
            });
        // this.langagesService.emitLangagesSubject();


        this.frameworksService.getFrameworks();
        this.frameworksSubscription = this.frameworksService.frameworksSubject.subscribe(
            (frameworks: any[]) => {
                this.frameworks = frameworks;
            });
        // this.frameworksService.emitFrameworksSubject();


        this.librariesService.getLibraries();
        this.librariesSubscription = this.librariesService.librariesSubject.subscribe(
            (libraries: any[]) => {
                this.libraries = libraries;
        });
        // this.librariesService.emitLibrariesSubject();


        this.initForm();
    }

    initForm() {
        this.docForm = this.formBuilder.group({
            permissions: ['', Validators.required],
            os: [''],
            langages: [''],
            frameworks: [''],
            libraries: [''],
            content: ['', Validators.required]
        });
    }

    onSubmitDoc() {
        const formValue = this.docForm.value;
        const newDoc = new Doc(
            5,
            formValue["permission"],
            formValue["os"] ? formValue["os"] : [],
            formValue["langages"] ? formValue["langages"] : [],
            formValue["frameworks"] ? formValue["frameworks"] : [],
            formValue["libraries"] ? formValue["libraries"] : [],
            formValue["content"]
        )
        console.log("newDoc " + newDoc);
        this.documentationService.addDocumentation(newDoc);
        this.documentationService.saveDoc();
        this.router.navigate(["documentation"]);
    }




    // Add OS
    addOs = false;
    newOs!: string;

    onAddOsInput() {
        this.addOs = true;
    }

    onAddOs() {
        this.langages.push({
            id: this.langages.length - 1,
            name: this.newOs
        });
        this.newOs = "";
        this.addOs = false;
    }

    // Add Langage
    addLangage = false;
    newLangage!: string;

    onAddLangagekInput() {
        this.addLangage = true;
    }

    onAddLangage() {
        this.os.push({
            id: this.os.length - 1,
            name: this.newFramework
        });
        this.newLangage = "";
        this.addLangage = false;
    }

    // Add Framework
    addFramework = false;
    newFramework!: string;

    onAddFrameworkInput() {
        this.addFramework = true;
    }

    onAddFramework() {
        this.frameworksService.addFramework({
            id: this.frameworksService.frameworks.length - 1,
            name: this.newFramework
        });
        this.newFramework = "";
        this.addFramework = false;
    }

    // Add Library
    addLibrary = false;
    newLibrary!: string;

    onAddLibraryInput() {
        this.addLangage = true;
    }

    onAddLibrary() {
        this.libraries.push({
            id: this.libraries.length - 1,
            name: this.newLibrary
        });
        this.newLibrary = "";
        this.addLibrary = false;
    }
}
