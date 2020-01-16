<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        ${message?ifExists}
    </div>
    <br>
    <p>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
                aria-expanded="false" aria-controls="collapseExample">
            New message
        </button>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form action="/sendMail">
                <div class="form-group">
                    <input type="text" class="form-control" name="receiver" placeholder="Кому"/>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="subject" placeholder="Тема">
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1"></label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" name="text"
                              placeholder="Ваше сообщение" rows="10"></textarea>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </div>
            </form>
        </div>
    </div>


</@c.page>
