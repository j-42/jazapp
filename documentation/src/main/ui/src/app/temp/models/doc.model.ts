export class Doc {

    constructor(
        public id:number, 
        public permissions:string, 
        public os:string[], 
        public langage:string[],
        public framework:string[],
        public library:string[],
        public content:string
    ){}

} 