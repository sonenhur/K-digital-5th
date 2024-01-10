import { useEffect, useState } from "react";
import SubwayArea from '../DB/SubwayArea.json'
export default function SubwayInfo() {
  const apikey = process.env.REACT_APP_API_KEY;
  const [ops, setOps] = useState([]);

  const getData = async (cd) => {
    let url = `https://apis.data.go.kr/6260000/IndoorAirQuality/getIndoorAirQualityByStation`
    url = url + `?serviceKey=${apikey}`
    url = url + `&pageNo=1`
    url = url + `&numOfRows=5`
    url = url + `&resultType=json`
    url = url + `&controlnumber=2024010918`
    url = url + `&areaIndex=${cd}`

    const resp = await fetch(url);
    const data = await resp.json();

    console.log(data.getIndoorAirQualityByStation.body.items.item[0])
  }
  const  handleSelectArea = (e)=>{
    console.log(e.target.value)
    getData(e.target.value);
  }
  useEffect(() => {
    console.log(SubwayArea)
    let tm = SubwayArea.map((item, idx) => (
      <option key={idx} value={item['코드']}>
        {item['측정소']}
      </option>
    ));
    setOps(tm)
   
  }, [])

  return (
    <div>
      <div className='w-full h-full flex flex-col items-center justify-center'>
        대기정보확인 지역선택
      </div>
      <div className="w-full">
        <select onChange={handleSelectArea}
          id="countries"
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
          <option value="">---지역 선택---</option>
          {ops}
        </select>
      </div>
      <div className="grid-cols-1 md:grid-cols-3 ">자료</div>
    </div>
  );
  
}
