import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/users.model';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-users-create',
  templateUrl: './users-create.component.html',
  styleUrls: ['./users-create.component.styl']
})
export class UsersCreateComponent implements OnInit {

  // Object formulaire qui corrrespond au template
  userForm!: FormGroup;

  constructor(private fromBuilder:FormBuilder, private usersService:UsersService, private router: Router) { }

  ngOnInit(): void {
    this.initForm()
  }

  initForm(){
    this.userForm = this.fromBuilder.group({
      firstName:["", Validators.required], // default + validateur
      lastName:["", Validators.required],
      pseudo:["", Validators.required],
      email:["", [Validators.required, Validators.email] ],
      permission: ["", Validators.required],
    });
  }

  onSubmitUser(){
    const formValue = this.userForm.value;
    const newUser = new User(formValue["firstName"],formValue["lastName"],formValue["pseudo"],formValue["email"],formValue["permission"])
    this.usersService.addUser(newUser);
    this.router.navigate(['/users']);
  }

}
