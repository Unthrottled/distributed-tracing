"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Message = /** @class */ (function () {
    function Message(value) {
        this.value = value;
    }
    Object.defineProperty(Message.prototype, "succeeded", {
        get: function () {
            return this.value.indexOf("Try again") < 0;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Message.prototype, "failed", {
        get: function () {
            return !this.succeeded;
        },
        enumerable: true,
        configurable: true
    });
    return Message;
}());
exports.Message = Message;
//# sourceMappingURL=Message.model.js.map