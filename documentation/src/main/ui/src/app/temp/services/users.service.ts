import { Subject } from 'rxjs';
import { User } from '../models/user.model';

export class UsersService{

    private users: User[] = [
        {
            id:0,
            firstName:"John", 
            lastName:"Doe", 
            pseudo:"Bob",
            email:"john.doe@unkown.com",
            permission:"noob"
        }
    ];

    usersSubject = new Subject<User[]>();

    emitUsers() {
        this.usersSubject.next(this.users.slice());
    }

    addUser(user:User) {
        user.id = this.users[(this.users.length - 1)].id + 1;
        this.users.push(user);
        this.emitUsers;
    }
}