/**
 * Created by Ivan on 10.9.2017..
 */
$(document).ready(function() {
    $.ajax({
        url:"http://localhost:8080/carOwner/{id}"
    }).then(function (data) {
        $('.carOwner-id').append(data.id);
        $('.carOwner-firstName').append(data.firstName);
        $('.carOwner-lastName').append(data.lastName);
    });
});