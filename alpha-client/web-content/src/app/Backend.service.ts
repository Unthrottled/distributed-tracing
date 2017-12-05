
import {HttpClient} from "@angular/common/http"
import {Observable} from "rxjs/Observable";
import {Message} from "./Message.model";
import {Injectable} from "@angular/core";

@Injectable()
export class BackendService {

    constructor(private httpClient: HttpClient) {
    }


    public fetchMessage(): Observable<Message> {
        return this.httpClient.get("./get/message", {
            responseType: "text"
        }).map(message => new Message(message));
    }
}