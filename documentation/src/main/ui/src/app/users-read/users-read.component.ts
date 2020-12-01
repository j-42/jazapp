import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { User } from '../models/users.model';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-users-read',
  templateUrl: './users-read.component.html',
  styleUrls: ['./users-read.component.styl']
})

export class UsersReadComponent implements OnInit, OnDestroy {

  users!: User[];
  usersSubscription!: Subscription;

  constructor(private usersService : UsersService) { }

  ngOnInit(): void {
    this.usersSubscription = this.usersService.usersSubject.subscribe(
      (users:User[]) => {
        this.users = users;
      }
    );
    this.usersService.emitUsers();
  }

  ngOnDestroy(){
    this.usersSubscription.unsubscribe();
  }
}
