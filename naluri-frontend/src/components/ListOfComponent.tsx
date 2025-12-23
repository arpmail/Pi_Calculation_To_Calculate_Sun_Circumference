import backgroundCover from "../assets/stardust.png";

export const MainContainer = ({ children }: any) => {
  return (
    <div className="relative overflow-hidden min-h-screen">{children}</div>
  );
};

export const Content = ({ children }: any) => {
  return (
    <div className="flex flex-col md:flex-row items-center justify-center gap-12 pt-8">
      {children}
    </div>
  );
};

export const BackgroundImage = () => {
  return (
    <div className="absolute inset-0 bg-black z-0 overflow-hidden">
      <div
        className="w-full h-full animate-moveStars"
        style={{
          backgroundImage: `url(${backgroundCover})`,
        }}
      />
    </div>
  );
};
export const MainTitle = ({ children }: any) => {
  return (
    <div className="text-white mb-10 text-center">
      <h1 className="text-4xl font-bold text-center">{children}</h1>
    </div>
  );
};

export const Sun = () => {
  return (
    <div className="shrink-0">
      <div className="rounded-full bg-yellow-400 shadow-[0_0_80px_30px_orange] w-72 h-72 animate-pulse-slow animate-spin-slow" />
    </div>
  );
};

export const CircumferenceCalculation = ({
  data,
  displayNumber,
  countdown,
}: any) => {


  return (
    <div className="text-white text-xl flex flex-col gap-6 max-w-md pl-20">
      <div>
        Radius of the Sun: <span className="font-bold">696,340 km</span>
      </div>

      <div>
        Current known value of π from the server :{" "}
        <span className="font-bold">{Number(data.piValue).toFixed(15)}</span>
      </div>

      <div>
        Next queried from server in:{" "}
        <span className="font-bold text-yellow-300">{countdown}</span> seconds
        <div className="text-sm text-red-500">Last updated on : {data.lastUpdatedTimestamp}</div>
      </div>

      <div>
        Circumference of the Sun (km):
        <div className="text-sm">Formula used = 2 × π × radius of the sun</div>
        <div className="font-mono font-bold text-yellow-300 text-xl mt-1">
          {displayNumber.toFixed(2)}
        </div>
      </div>
    </div>
  );
};
