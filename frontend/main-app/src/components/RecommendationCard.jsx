import recommendation from "../assets/recommendation.json";

function RecommendationCard(props) {
  return (
    <div>
      <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg transition ease-in-out delay-150 hover:scale-105 duration-300">
        <h1> {recommendation[0].recommendation}</h1>
      </div>
      <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg transition ease-in-out delay-150 hover:scale-105 duration-300">
        <h1> {recommendation[1].recommendation}</h1>
      </div>
      <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg transition ease-in-out delay-150 hover:scale-105 duration-300">
        <h1> {recommendation[2].recommendation}</h1>
      </div>
    </div>
  );
}

export default RecommendationCard;
