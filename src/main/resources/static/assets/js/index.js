$(function() {
    $('#modifyBtn').on('click', () => {
        let data = {}

        $.ajax({
            data: data,
            type: 'get',
            url: '/editboard',
            Success: () => {
                console.log('수정하기');
                window.location.href='/editboard';
            }
        });
    })
});