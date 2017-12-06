import {Component} from "@angular/core";
import "./app.component.htm";
import {Message} from "./Message.model";
import {BackendService} from "./Backend.service";

@Component({
    selector: 'angular-application',
    template: require('./app.component.htm')
})
export class AppComponent {
    private messages: Message[] = [];


    constructor(private backendService: BackendService) {

    }

    public fetchMessage(): void {
        this.backendService.fetchMessage()
            .subscribe(oneMessage=> this.messages.push(oneMessage),
                (e)=>this.messages.push(new Message("Dayyuum, We had issuse even trying to talk to the backend! Try again, maybe it will fix itself.")));
    }

    public clearMessages(): void {
        this.messages = [];
    }
}
