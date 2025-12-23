import { useEffect, useState } from "react";
import {
  BackgroundImage,
  CircumferenceCalculation,
  Content,
  MainContainer,
  MainTitle,
  Sun,
} from "../components/ListOfComponent";
import Decimal from "decimal.js";
import NumberAnimation from "../components/NumberAnimation";

const url = import.meta.env.VITE_API_URL;
const radiusOfTheSun = 696340;

type piProps = {
  piValue: string;
  totalIteration: string;
  lastUpdatedTimestamp: string;
};
const CircumferenceOfTheSun = () => {
  const [data, setData] = useState<piProps>({
    piValue: "3.0",
    totalIteration: "",
    lastUpdatedTimestamp: "",
  });

  const [sunCircumference, setSunCircumference] = useState<any>(
    localStorage.getItem("latestCircumference")
  );
  const [displayNumber, setDisplayNumber] = useState<number>(0);
  const [countdown, setCountdown] = useState(5);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch(url + "/pi");
        const result = await res.json();

        if (result) {

          const updatedDate = new Date(result.lastUpdatedTimestamp);

          setData({
            piValue: result.valueOfPi,
            totalIteration: result.iteration,
            lastUpdatedTimestamp: updatedDate.toLocaleString(),
          });
        }
      } catch (err) {
        console.log("error ", err);
      }
    };

    fetchData();

    const interval = setInterval(fetchData, 5000);
    return () => {
      clearInterval(interval);
    };
  }, []);

  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => (prev > 1 ? prev - 1 : 5));
    }, 1000);

    return () => clearInterval(timer);
  }, []);

  useEffect(() => {
    if (data.piValue && !isNaN(Number(data.piValue))) {
      const convertPiToDecimal = new Decimal(data.piValue);
      const result = convertPiToDecimal.mul(radiusOfTheSun).mul(2);
      const res = Number(result.toString());
      setSunCircumference(res);

      localStorage.setItem("latestCircumference", res.toString());
    }
  }, [data]);

  // Smooth number animation using requestAnimationFrame
  useEffect(() => {
    NumberAnimation({
      displayNumber,
      setDisplayNumber,
      sunCircumference,
    });
  }, [sunCircumference]);

  return (
    <MainContainer>
      <BackgroundImage />

      <div className="relative z-10 w-full h-full flex items-center justify-center px-6 pt-20">
        <div className="flex flex-col items-center">
          <MainTitle>Circumference of the Sun</MainTitle>

          <Content>
            <Sun />
            <CircumferenceCalculation
              data={data}
              displayNumber={displayNumber}
              countdown={countdown}
            />
          </Content>
        </div>
      </div>
    </MainContainer>
  );
};

export default CircumferenceOfTheSun;
