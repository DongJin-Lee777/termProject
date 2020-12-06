let boardData = [0,0,0,0,0,0,0,0,0];
let commData = [0,0,0,0,0,0,0,0,0];

function indexCheck(tmp) {
    if(tmp >= 0 && tmp <= 2) {
        tmp = 0;
    } else if(tmp <= 5) {
        tmp = 1;
    } else if(tmp <= 8) {
        tmp = 2;
    } else if(tmp <= 11) {
        tmp = 3;
    } else if(tmp <= 14) {
        tmp = 4;
    } else if(tmp <= 17) {
        tmp = 5;
    } else if(tmp <= 20) {
        tmp = 6;
    } else if(tmp <= 23) {
        tmp = 7;
    } else if(tmp === 24) {
        tmp = 8;
    }
    return tmp;
}

function insertData(data, dates, cnts) {
    for(let i = 0; i < dates.length; i++) {
        let tmp = dates[i].substring(11,13);
        tmp = indexCheck(tmp);
        data[tmp] = cnts[i];
    }
}

insertData(boardData, boardDates, boardCnts);
insertData(commData, commDates, commCnts);

new Chart(document.getElementById("boardChart"), {
    type: 'line',
    data: {
        labels: ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
        datasets: [{
            data: boardData,
            borderColor: "rgba(255, 201, 14, 1)",
            backgroundColor: "rgba(255, 201, 14, 0.5)",
            fill: true,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: '게시글 수'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true
                }
            }],
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                }
            }]
        }
    }
});



new Chart(document.getElementById("CommChart"), {
    type: 'line',
    data: {
        labels: ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
        datasets: [{
            data: commData,
            borderColor: "rgba(255, 201, 14, 1)",
            backgroundColor: "rgba(255, 201, 14, 0.5)",
            fill: true,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: '댓글 수'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true
                }
            }],
            yAxes: [{
                display: true,
                ticks: {
                    suggestedMin: 0,
                }
            }]
        }
    }
});