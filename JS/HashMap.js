window.onload = function () {
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
            },
            get: function (key) {
                return map[key];
            },
            clear: function () {
                map = {};
            }
        };
    };
    const tagArticle = document.querySelector('article');
    const dataMap = new HashMap();

    document.getElementById("putBtn").addEventListener('click', function () {

        const newKey = document.getElementById("key").value;
        const newValue = document.getElementById("value").value;
        
        //not Empty
        if (!newKey.trim()) {
            alert('Key不得為空或空格，請重新輸入');
            return;
        }
        //not repeated
        if (dataMap.contains(newKey)) {
            alert('Map內已有重複的key，請重新輸入')
            return;
        }
        dataMap.put(newKey, newValue);

        tagArticle.innerHTML = '';
        const tagP = document.createElement('p');
        tagP.innerHTML = '【RESULT】';
        tagArticle.appendChild(tagP);
        const keys = dataMap.keys();
        let tagP1 = '';
        for (let k of keys) {
            tagP1 = document.createElement('p');
            tagP1.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' + k + '&nbsp:&nbsp' + dataMap.get(k);
            tagArticle.appendChild(tagP1);
        }

    });

    document.getElementById("clearBtn").addEventListener('click', function () {
        dataMap.clear();
        tagArticle.innerHTML = '';
        document.getElementById("key").value = '';
        document.getElementById("value").value = '';

    });
}


