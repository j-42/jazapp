import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.styl'],
})
export class AuthComponent implements OnInit {

  authStatut: boolean = false;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.authStatut = this.authService.isAuth;
  }

  onSignIn(){
    this.authService.signIn().then( () => {
        console.log('connexion reussi');
        this.authStatut = this.authService.isAuth;
      //  this.router.navigate(['documentation']);
    });
  }
  onSignOff(){
    this.authService.signOff();
    this.authStatut = this.authService.isAuth;
  }

}
