/**
 * 使用說明
 * 1. psychometricTest 心理測驗題目，結構說明：
 *  Q1: {                                                                       <-題號
 *      question: '處理眾多的事情，你會先處理困難的還是簡單事情？',            <-題目
 *      ans: ['困難的事情', '簡單的事情', '分配處理',],                         <-選項
 *      next: ['Q2', 'Q3', 'Q4']                                                <-選項下一題，困難的事情(Q2), 簡單的事情(Q3), 分配處理(Q4)
 *  },
 *  
 * 
 *  2. result 心理測驗結果，結構說明：
 *  A: {                                                                        <-答案A
 *      title: '知道做不到',                                                    <-答案標題
 *      content: '你習慣嘗試當下最流行的減重方法（例如：喝XX一週瘦7.....'      <-答案說明
 *  },
 */


window.onload = function () {


    const psychometricTest = {
        Q1: {
            question: '處理眾多的事情，你會先處理困難的還是簡單事情？',
            ans: ['困難的事情', '簡單的事情', '分配處理',],
            next: ['Q2', 'Q3', 'Q4']
        },
        Q2: {
            question: '只要有看到美食廣告會馬上搜尋？',
            ans: ['是', '否',],
            next: ['Q5', 'Q6']
        },
        Q3: {
            question: '做事總是有計畫及規劃才會行動？',
            ans: ['是', '否',],
            next: ['Q7', 'Q6']
        },
        Q4: {
            question: '減重一輩子都在嘗試，沒有一次成功過？',
            ans: ['是', '否',],
            next: ['Q7', 'Q8']
        },
        Q5: {
            question: '常常一時興起做某些事情，卻總是沒有結果？',
            ans: ['是', '否',],
            next: ['Q9', 'Q10']
        },
        Q6: {
            question: '周末常以躺在沙發看電視度過？',
            ans: ['是', '否',],
            next: ['Q9', 'Q11']
        },
        Q7: {
            question: '一群人聚餐，總是由你決定餐廳？',
            ans: ['是', '否',],
            next: ['Q10', 'Q12']
        },
        Q8: {
            question: '看到親友瘋流行減重，會覺得只是白費力氣？',
            ans: ['是', '否',],
            next: ['Q11', 'Q12']
        },
        Q9: {
            question: '看到廣告某樣瘦身產品，會立即訂購嘗試？',
            ans: ['是', '否',],
            next: ['A', 'B',],

        },
        Q10: {
            question: '喜歡從事戶外活動，郊外踏青？',
            ans: ['是', '否',],
            next: ['A', 'C',],
        },
        Q11: {
            question: '反正瘦了一定會再胖，不如不要浪費時間？',
            ans: ['是', '否',],
            next: ['B', 'D',],
        },
        Q12: {
            question: '常常一忙碌起來就忘記吃飯？',
            ans: ['是', '否',],
            next: ['C', 'D',],
        },
    }

    const result = {
        A: {
            title: '知道做不到',
            content: '你習慣嘗試當下最流行的減重方法（例如：喝XX一週瘦7公斤、吃躺着也能瘦……等），你主要偏向於「速效」，你認爲減重就應該快速，短時間內完成，所以嘗試各種方法，即使知道不太可能會成功，但你還是會姑且一試，你就是在衆多減重者裡常見的類型，簡單來說因爲你太聰明瞭，其實正確觀念都知道，卻做不到，你真的有準備好減重嗎？準備好了，怎麼做不到？ 還一直想要嘗試不正確的速效減重方法，其實你只要靜下心，好好確立減重目標，逐步進行減重計劃，你絕對就能瘦了，快把你的聰明用在正確減重上吧！加油！'
        },
        B: {
            title: '不知道做不到',
            content: '簡單來說，你的減重計劃失敗收場是情有可原，因爲你根本不知道一些正確觀念，怎麼會做好呢？永遠覺得自己是易胖體質，不容易瘦，總是在減重這條路上跌跌撞撞，試過了無數減重方法，卻沒一樣成功過，不過別擔心，其實你只要建立正確觀念，逐步執行減重計劃，你就能瘦囉！對你而言減重不難，加油！'
        },
        C: {
            title: '不知道做到',
            content: '這你聽起來一定覺得很詭異，明明不知道，卻還做得到，其實你主要受到家庭飲食習慣影響，從小家裡養成的良好飲食習慣，久而久之習慣成自然，當然，理論上你有良好飲食習慣不太需要減重，但如果逐漸成長、工作忙碌、外食機會多，漸漸受到家庭飲食習慣影響越來越少，就很容易造成你逐漸變胖的原因，其實你只要好好了解正確觀念，你一樣可以瘦得很好，加油！'
        },
        D: {
            title: '知道做到',
            content: '你就是最典型的乖寶寶，知道正確觀念，並且會好好執行，你很清楚自己減重的目標爲何（例如：健康、想穿漂亮衣服……等），通常你只要確立減重目標，接下來的減重計劃都會很順利，瘦得很穩定，不太需要操心，因爲你是知道做到的完美主義者，逐步執行，你就會成功！加油！'
        },
    }

    //hash map
    const HashMap = function () {
        let map = {};
        return {
            put: function (key, value) {
                map[key] = value;
            },
            keys: function () {
                const keySet = [];
                for (let key in map) {
                    keySet.push(key);
                }
                return keySet;
            },
            contains: function (key) {
                for (let k in map) {
                    if (k === key) {
                        return true;
                    }
                }
                return false;
                //return key in map;
            },
            get: function (key) {
                return map[key];
            },
            clear: function () {
                map = {};
            }
        };
    };

    //let psychometrucTest be a Map
    const testMap = new HashMap();
    for (let key in psychometricTest) {
        testMap.put(key, psychometricTest[key]);
    }
    //let result be a Map
    const resultMap = new HashMap();
    for (let key in result) {
        resultMap.put(key, result[key]);
    }
    //add no's question below
    function nextQ(map, num) {

        const contentTable1 = document.getElementById("content");
        const tagTr = document.createElement('tr');
        const tagTdNo = document.createElement('td');
        const tagTdQ = document.createElement('td');
        const tagTdAns = document.createElement('td');
        const tagTdNext = document.createElement('td');
        //tdNo
        tagTdNo.innerHTML = num;
        tagTr.appendChild(tagTdNo);
        //tdQ
        tagTdQ.innerHTML = map.get(num).question;
        tagTr.appendChild(tagTdQ);
        //tdAns
        const tagLabel0 = document.createElement('label');
        const tagInput0 = document.createElement('input');
        tagInput0.setAttribute("type", "radio");
        tagInput0.setAttribute("name", "ans");
        tagLabel0.appendChild(tagInput0);
        tagLabel0.append('是');

        const tagLabel1 = document.createElement('label');
        const tagInput1 = document.createElement('input');
        tagInput1.setAttribute("type", "radio");
        tagInput1.setAttribute("name", "ans");
        tagLabel1.appendChild(tagInput1);
        tagLabel1.append('否')

        const tagBr = document.createElement('br');
        tagTdAns.appendChild(tagLabel0);
        tagTdAns.appendChild(tagBr);
        tagTdAns.appendChild(tagLabel1);
        tagTdAns.setAttribute("id", "ans");
        tagTr.appendChild(tagTdAns);
        //tdNext
        const tagButton = document.createElement('button');
        tagButton.setAttribute("type", "button");
        tagButton.setAttribute("id", "next");
        tagButton.innerHTML = '下一題';
        tagTdNext.appendChild(tagButton);
        tagTr.appendChild(tagTdNext);

        contentTable1.appendChild(tagTr);
    }
    //recall
    function again(map, num) {

        const ansArr = document.getElementById("ans");
        const ansA = ansArr.childNodes;
        const inputText0A = ansA[0].childNodes;
        const inputText1A = ansA[2].childNodes;//since <br>
        const nextTdA = document.getElementById("next");
        //set nextBtn and check ans
        nextTdA.addEventListener('click', function () {
            if (inputText0A[0].checked) {
                num = map.get(num).next[0];
            } else if (inputText1A[0].checked) {
                num = map.get(num).next[1];
            }
            //set disable
            nextTdA.setAttribute("disabled", "true");
            inputText0A[0].setAttribute("disabled", "true");
            inputText1A[0].setAttribute("disabled", "true");

            if (!map.contains(num)) {
                showResult(num);
                return;
            }

            nextQ(map, num);
            ansArr.removeAttribute("id");
            nextTdA.removeAttribute("id");

            again(map, num)
        })
    }
    //link result
    function showResult(num) {
        const resultDiv = document.getElementById("result");
        const tagH3 = document.createElement('h3');
        const tagP = document.createElement('p');
        tagH3.innerHTML = num + '&nbsp&nbsp' + resultMap.get(num).title;
        tagP.innerHTML = resultMap.get(num).content;
        resultDiv.appendChild(tagH3);
        resultDiv.appendChild(tagP);
        //create restartBtn
        const restartBtn = document.createElement('button');
        restartBtn.setAttribute("type", "button");
        restartBtn.innerHTML = '重新測試'
        restartBtn.addEventListener('click', function () {
            const startTr0 = document.getElementById("start0");
            const startTr1 = document.getElementById("start1");
            const contentTable = document.getElementById("content");
            contentTable.innerHTML = '';
            contentTable.appendChild(startTr0);
            contentTable.appendChild(startTr1);
            console.log(contentTable)
            resultDiv.innerHTML = '';
            start();
        });
        resultDiv.appendChild(restartBtn);
    }

    //set start and restart
    function start() {
        no = 'Q1';
        inputText0[0].removeAttribute('disabled');
        inputText1[0].removeAttribute('disabled');
        inputText2[0].removeAttribute('disabled');
        nextTd[0].removeAttribute('disabled');
    }



    //start to run
    let no = 'Q1';
    const ansArr1 = document.getElementById("ans1");
    const ans = ansArr1.childNodes;
    const inputText0 = ans[0].childNodes;
    const inputText1 = ans[3].childNodes;//since <br>
    const inputText2 = ans[6].childNodes;
    const nextTd1 = document.getElementById("next1");
    const nextTd = nextTd1.childNodes;

    start();

    //set nextBtn and check ans
    nextTd[0].addEventListener('click', function () {
        if (inputText0[0].checked) {
            no = testMap.get(no).next[0];
        } else if (inputText1[0].checked) {
            no = testMap.get(no).next[1];
        } else if (inputText2[0].checked) {
            no = testMap.get(no).next[2];
        }
        nextQ(testMap, no);
        //set disable
        nextTd[0].setAttribute("disabled", "true");
        inputText0[0].setAttribute("disabled", "true");
        inputText1[0].setAttribute("disabled", "true");
        inputText2[0].setAttribute("disabled", "true");

        again(testMap, no);
    });















}
