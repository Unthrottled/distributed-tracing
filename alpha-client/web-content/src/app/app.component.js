"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
require("./app.component.htm");
var Message_model_1 = require("./Message.model");
var Backend_service_1 = require("./Backend.service");
var AppComponent = /** @class */ (function () {
    function AppComponent(backendService) {
        this.backendService = backendService;
        this.messages = [new Message_model_1.Message('ayy lmao')];
    }
    AppComponent.prototype.fetchMessage = function () {
        var _this = this;
        this.backendService.fetchMessage()
            .subscribe(function (oneMessage) { return _this.messages.push(oneMessage); });
    };
    AppComponent.prototype.clearMessages = function () {
        this.messages = [];
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'angular-application',
            template: require('./app.component.htm')
        }),
        __metadata("design:paramtypes", [Backend_service_1.BackendService])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map