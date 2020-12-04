$(function () {
    // 회원가입
    $('#join').on('click', function () {

        let data = {
            email: $('#email').val(),
            pwd: $('#joinPW').val(),
            id: $('#joinId').val(),
            gender: $('.gender:checked').val(),
            auth: $('#auth').val(),
            major: $('#major').val()
        }

        if (isEmpty(data.email) || isEmpty(data.pwd) || isEmpty(data.id) ||
            isEmpty(data.gender) || isEmpty(data.auth) || isEmpty(data.major)) {
            alert('모든 항목을 채워주세요');
        } else {
            return;
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/join',
            success: function () {
                window.location.href = '/';
            }
        });
    });

    // 로그인
    $('#loginBtn').on('click', () => {
        let data = {
            email: $('#loginEmail').val(),
            pwd: $('#loginPW').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/login',
            success: function () {
                location.reload();
            }
        });
    });

    // 글 작성 (페이지 이동)
    $('#writeBoardBtn').on('click', () => {
        window.location.href = '/writeBoard';
    });

    // 글 작성
    $('#writeEndBtn').on('click', () => {
        let data = {
            title: $('#title').val(),
            bcontent: $('#content').text(),
            bwriter: $('#id').val(),
            category_cd: $('#category').val()
        }

        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/writeBoard',
            success: () => {
                window.location.href = '/boardList?category='+data.category_cd;
            }
        });
    });

    // 글 수정 (페이지 이동)
    $('#modifyBtn').on('click', () => {
        let bno = $('#bno').val();
        window.location.href = '/editBoard/' + bno;
    });

    // 글 수정
    $('button#modifyEndBtn').on('click', () => {
        let data = {
            bno: $('#bno').val(),
            title: "[수정]" + $('#title').val(),
            bcontent: $('#content').text(),
        }

        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/editBoard',
            success: () => {
                window.location.href = '/board/' + data.bno;
            }
        });
    });

    // 글 삭제
    $('#deleteBtn').on('click', () => {
        let data = {
            bno: $('#bno').val(),
        }

        $.ajax({
            data: data,
            type: 'delete',
            url: '/rest/deleteBoard',
            success: () => {
                window.location.href = '/boardList';
            }
        });
    });

    // 이메일 전송
    $('#sendEmail').on('click', function () {
        let data = {
            userEmail: $('#email').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/email',
            success: function () {
                alert('인증번호를 전송했습니다.');
            }
        });
    });

    // 인증
    $('#confirm').on('click', function () {

        let data = {
            confirm: $('#confirmCode').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/confirm',
            success: function (i) {
                if (i == 1) {
                    alert('인증되었습니다.');
                    $('#join').attr('disabled', false);
                } else alert('인증 실패');
            }
        });
    });
});
// 댓글 등록
function writeComm(cno){
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'delete',
        url: '/rest/deleteComm',
        success: () => {
            location.reload();
        }
    });
}

// 댓글 수정
function editComm(cno){
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'delete',
        url: '/rest/deleteComm',
        success: () => {
            location.reload();
        }
    });
}
// 댓글 삭제
function deleteComm(cno){
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'delete',
        url: '/rest/deleteComm',
        success: () => {
            location.reload();
        }
    });
}

// 좋아요 증가
function up(bno) {
    let data = {
        bno: bno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/up',
        success: function () {
            location.reload();
        }
    });
}

// 좋아요 하락
function down(bno) {
    let data = {
        bno: bno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/down',
        success: function () {
            location.reload();
        }
    });
}

let isEmpty = (object) => {
    return object === '' || object == null || object === 0 || isNaN(object) || object === undefined;
}