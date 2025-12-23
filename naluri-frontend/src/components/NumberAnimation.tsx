const NumberAnimation = ({displayNumber, setDisplayNumber, sunCircumference}: any) => {
  let start = displayNumber;
  const end = sunCircumference;
  const duration = 1000; // animation duration in ms
  const startTime = performance.now();

  const animate = (time: number) => {
    const progress = Math.min((time - startTime) / duration, 1);
    setDisplayNumber(start + (end - start) * progress);
    if (progress < 1) requestAnimationFrame(animate);
  };

  requestAnimationFrame(animate); // animation from browser api to call the function before the next screen rendering
};

export default NumberAnimation;
