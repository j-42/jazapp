import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchEngineComponent } from './search-engine/search-engine.component';

import { DocumentationService } from './services/documentation.service';

import { AuthComponent } from './auth/auth.component';
import { AuthService } from './services/auth.service';

import {RouterModule, Routes} from "@angular/router";
import { HttpClientModule } from '@angular/common/http';
import { DocumentationComponent } from './documentation/documentation.component';
import { EditDocumentationComponent } from './edit-documentation/edit-documentation.component';


const appRoutes : Routes = [
  {path: 'documentation', component: DocumentationComponent},
  {path: 'documentation/new', component: EditDocumentationComponent},
  {path: 'auth', component: AuthComponent},
  {path: '', component: DocumentationComponent},
  { path: 'not-found', component: AuthComponent },
  { path: '**', redirectTo: 'not-found' }
];

@NgModule({
  declarations: [
    AppComponent,
    SearchEngineComponent,
    AuthComponent,
    DocumentationComponent,
    EditDocumentationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    DocumentationService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
