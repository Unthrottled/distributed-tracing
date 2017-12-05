import {Component, OnInit} from "@angular/core";
import "./app.component.htm";
import {Message} from "./Message.model";

@Component({
    selector: 'angular-application',
    template: require('./app.component.htm')
})
export class AppComponent implements OnInit {
    ngOnInit(): void {
    }

    private messages: Message[] = [];
}
