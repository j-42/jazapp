import { Subject } from 'rxjs';
import { User } from '../models/users.model';

export class UsersService{

    private users: User[] = [
        {
            firstName:"John", 
            lastName:"Doe", 
            pseudo:"Bob",
            email:"john.doe@unkown.com",
            persmission:"noob"
        }
    ];

    usersSubject = new Subject<User[]>();

    emitUsers() {
        this.usersSubject.next(this.users.slice());
    }

    addUser(user:User) {
        this.users.push(user);
        this.emitUsers;
    }
}