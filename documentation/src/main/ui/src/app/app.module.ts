import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchEngineComponent } from './search-engine/search-engine.component';

import { DocumentationService } from './services/documentation.service';

import { AuthComponent } from './auth/auth.component';
import { AuthService } from './services/auth.service';

import {RouterModule, Routes} from "@angular/router";
import { HttpClientModule } from '@angular/common/http';

import { UsersService } from './services/users.service';
import { DocumentationReadComponent } from './documentation-read/documentation-read.component';
import { DocumentationCreateComponent } from './documentation-create/documentation-create';
import { UsersReadComponent } from './users-read/users-read.component';
import { UsersCreateComponent } from './users-create/users-create.component';
import { FrameworksService } from './services/frameworks.service';
import { OsService } from './services/os.service';
import { LangagesService } from './services/langagesService';
import { LibrariesService } from './services/LibrariesService';
import { PermissionsService } from './services/permissionsService';


const appRoutes : Routes = [
  {path: 'documentation', component: DocumentationReadComponent},
  {path: 'documentation/new', component: DocumentationCreateComponent},
  {path: 'users', component: UsersReadComponent},
  {path: 'users/new', component: UsersCreateComponent},
  {path: 'auth', component: AuthComponent},
  {path: '', component: DocumentationReadComponent},
  { path: 'not-found', component: AuthComponent },
  { path: '**', redirectTo: 'not-found' }
];

@NgModule({
  declarations: [
    AppComponent,
    SearchEngineComponent,
    AuthComponent,
    DocumentationReadComponent,
    DocumentationCreateComponent,
    UsersReadComponent,
    UsersCreateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    DocumentationService,
    FrameworksService,
    LangagesService,
    LibrariesService,
    OsService,
    PermissionsService,
    UsersService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
