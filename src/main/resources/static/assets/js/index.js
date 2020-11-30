$(function() {

    // 글 수정 (페이지 이동)
    $('#modifyBtn').on('click', () => {
        let data = {}

        $.ajax({
            data: data,
            type: 'get',
            url: '/editBoard',
            success: () => {
                console.log('수정하기');
                window.location.href='/editBoard';
            }
        });
    })

    // 글 수정
    $('#modifyEndBtn').on('click', () => {
        let data = {}

        $.ajax({
            data: data,
            type: 'post',
            url: '/board',
            success: () => {
                console.log('수정완료');
                window.location.href='/board';
            }
        });
    })
});