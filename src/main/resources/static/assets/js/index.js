$(function () {
    // 회원가입
    $('#join').on('click', function () {

        let data = {
            email: $('#email').val(),
            pwd: $('#joinPW').val(),
            id: $('#joinId').val(),
            gender: $('.gender:checked').val(),
            auth: $('#joinAuth').val(),
            major: $('#major').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/join',
            success: function () {
                alert('회원가입 완료했습니다.');
                window.location.href = '/';
            }
        });
    });

    // 비밀번호 찾기
    $('#search').on('click', () => {
        let data = {
            email: $('#searchEmail').val(),
            id: $('#searchId').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/findPw',
            success: function (data) {
                if(data == "" || data == null) {
                    alert("학번이 틀렸거나 존재하지 않는 계정입니다.");
                } else {
                    alert("비밀번호 : " + data);
                }
                window.location.href = "/";
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

    // 로그아웃
    $('#logout').on('click', () => {
        $.ajax({
            type: 'put',
            url: '/rest/logout',
            success: function () {
                location.reload();
            }
        });
    });

    // 유저 기록 이동
    $('#writeLog').on('click', () => {
        let data = {
            id: $('#userid').text()
        }

        $.ajax({
            data: data,
            type: 'get',
            url: '/userLog',
            success: function () {
                window.location.href = '/userLog?id='+data.id;
            }
        });
    });


    // 회원정보 수정 이동
    $('#editUserBtn').on('click', () => {
        let data = {
            id: $('#editId').val(),
            pwd: $('#editPW').val(),
            major: $('#editMajor').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/editUser',
            success: function () {
                alert('수정되었습니다.');
                window.location.href = '/';
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
            category_cd: $('#category_cd').val()
        }

        console.log(category_cd);

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

    // 회원관리 이동
    $('#userManager').on('click', () => {
            $.ajax({
                type: 'get',
                url: '/userManager',
                success: () => {
                    window.location.href = '/userManager';
                }
            });
    });

    // 댓글 등록
    $('#commEditBtn').on('click', () => {

        let data = {
            bno: $('#bno').val(),
            cwriter: $('#cwriter').val(),
            ccontent: $('#commEditContent').text()
        }
        console.log(data.cwriter);
        console.log(data.ccontent);
        $.ajax({
            data: data,
            type: 'Put',
            url: '/rest/writeComm',
            success: () => {
                location.reload();
            }
        });
    })

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
// 관리자 글 삭제
function boardDel(bno) {
    let data = {
        bno: bno
    }

    $.ajax({
        data: data,
        type: 'delete',
        url: '/rest/deleteBoard',
        success: () => {
            location.reload();
        }
    });
}

// 댓글 수정
/*function editComm(cno){
    if($('.commContent').attr('contenteditable')) {
        let data = {
            cno: cno,
            ccontent: $('#commEditContent').text()
        }

        $.ajax({
            data: data,
            type: 'Put',
            url: '/rest/editComm',
            success: () => {
                $('.commContent').attr('contenteditable', 'false');
                location.reload();
            }
        });
    } else {
        $('.commContent').attr('contenteditable', 'true');
    }
}*/
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

// 게시물 좋아요 증가
function bup(bno) {
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

// 게시물 좋아요 하락
function bdown(bno) {
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

// 게시물 좋아요 증가
function cup(cno) {
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/commUp',
        success: function () {
            location.reload();
        }
    });
}

// 게시물 좋아요 하락
function cfun(cno) {
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/commFun',
        success: function () {
            location.reload();
        }
    });
}

// 게시물 좋아요 하락
function cdown(cno) {
    let data = {
        cno: cno
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/commDown',
        success: function () {
            location.reload();
        }
    });
}

// 유저 권한 변경
function editAuth(uno) {
    let data = {
        uno:uno,
        auth: auth
    }

    $.ajax({
        data: data,
        type: 'post',
        url: '/rest/editAuth',
        success: function (data) {
            editAuth(data);
        }
    });
}
