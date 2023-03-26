import { buildStyles, CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import VisibilitySensor from "react-visibility-sensor";

function CategoryCard(props) {
  var score1 = 36;
  var score2 = 26;
  var score3 = 13;
  var score4 = 18;

  return (
    <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg h-72">
      <div class="flex" style={{ width: 1220, height: 170 }}>
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? score1 : 0;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage}
                styles={{
                  path: {
                    stroke: `#FF6868`,
                    transition: "stroke-dashoffset 0.5s ease 0s",
                  },
                  text: {
                    fill: `#FF6868`,
                  },
                }}
              />
            );
          }}
        </VisibilitySensor>
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? score2 : 0;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage}
                styles={{
                  path: {
                    stroke: `#59D482`,
                    transition: "stroke-dashoffset 0.5s ease 0s",
                  },
                  text: {
                    fill: `#59D482`,
                  },
                }}
              />
            );
          }}
        </VisibilitySensor>
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? score3 : 0;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage}
                styles={{
                  path: {
                    stroke: `#FDBF53`,
                    transition: "stroke-dashoffset 0.5s ease 0s",
                  },
                  text: {
                    fill: `#FDBF53`,
                  },
                }}
              />
            );
          }}
        </VisibilitySensor>
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? score4 : 0;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage}
                styles={{
                  path: {
                    stroke: `#564AFF`,
                    transition: "stroke-dashoffset 0.5s ease 0s",
                  },
                  text: {
                    fill: `#564AFF`,
                  },
                }}
              />
            );
          }}
        </VisibilitySensor>
      </div>
      <div class="flex justify-between ml-16 mt-8 ">
        <p>Food: 33,000 MtCO2e</p>
        <p>Shopping: 22,120 MtCO2e</p>
        <p>Transportation: 10,390 MtCO2e</p>
        <p>Entertainment: 13,330 MtCO2e</p>
      </div>
    </div>
  );
}

export default CategoryCard;
