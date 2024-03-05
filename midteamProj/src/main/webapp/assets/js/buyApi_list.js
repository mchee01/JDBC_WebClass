const selectAll = function(){
	const xhr = new XMLHttpRequest()
	xhr.open('GET', 'api/buy/list')
	xhr.send()
	xhr.onload = function(){
		if(xhr.status === 200 || xhr.status === 201){
			console.log("요청 응답: ", xhr.response)
			const arr = JSON.parse(xhr.response)
			console.log("get api/buy/list", arr)
			
			const list = document.querySelector('#list')
			list.innerHTML = ''
			arr.forEach((ele, index) => {
				const li = document.createElement('li')
				const ul = document.createElement('ul')
				ul.className = 'row'
				ul.innerHTML =
				`<li>${index+1}</li>
				<li>${ele.customid}</li>
				<li>${ele.pcode}</li>
				<li style=\"text-align: center;\">${ele.quantity.toLocaleString('ko-KR')}</li>
				<li>${ele.buy_date}</li>`
				li.appendChild(ul)
				list.appendChild(li)
			})
		} else {
			console.error('오류1', xhr.status)
			console.error('오류2', xhr.response)
		}
	}
}

document.querySelector('#selectAll').addEventListener('click',selectAll)