window.onload = function () {
    const HashMap = function () {
        let map = {};
        return {
            put: function (key, value) {
                map[key] = value; //map.key === map['key']
            },
            keys: function () {
                const keySet = [];
                for (let key in map) {
                    keySet.push(key);
                }
                return keySet;
            },
            contains: function (key) {
                /*let isHas;
                for (let k in map) {
                    if (k === key) {
                        isHas = true;
                        break;
                    }else{
                        isHas = false
                    }
                }
                return isHas;*/

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
    const datas = new HashMap();

    document.getElementById("putBtn").addEventListener('click', function () {
               
        const newKey = document.getElementById("key").value;
        const newValue = document.getElementById("value").value;
        //not Empty
        if (!newKey) {
            return;
        }
        //not repeated
        if (datas.contains(newKey)) {
            return;
        }
        datas.put(newKey, newValue);
        
        tagArticle.innerHTML='';
        const tagP = document.createElement('p');
        const tagBr = document.createElement('br');
        tagP.innerHTML = '【RESULT】';
        tagArticle.appendChild(tagP);
        const keys = datas.keys();
        let tagP1 = '';
        for (let k of keys) {
            tagP1 = document.createElement('p');
            tagP1.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' + k + '&nbsp:&nbsp' + datas.get(k);
            tagArticle.appendChild(tagP1);
        }

    });

    document.getElementById("clearBtn").addEventListener('click', function () {
        datas.clear();
        tagArticle.innerHTML='';
        document.getElementById("key").value = '';
        document.getElementById("value").value = '';

    });
}


