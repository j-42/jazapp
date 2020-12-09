import { Framework } from './framework.model';
import { Langage } from './langage.model';
import { Library } from './library.model';
import { Os } from './os.model';
import { Permission } from './permission.model';

export class Doc {

    constructor(
        public id:number,

        public permissions: Permission[] ,
        public os: Os[],
        public frameworks: Framework[],
        public langages: Langage[],
        public libraries: Library[],

        public content:string
         
    ){}

} 