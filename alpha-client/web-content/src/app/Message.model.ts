
export class Message {

    constructor(public value: string){

    }

    get succeeded(): boolean {
        return this.value.indexOf("Try again") < 0;
    }

    get failed(): boolean {
        return !this.succeeded;
    }
}