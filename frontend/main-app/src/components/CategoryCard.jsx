import { useEffect, useState } from "react";
import { buildStyles, CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import VisibilitySensor from "react-visibility-sensor";
import axios from "axios";
import data from "../assets/data.json";

function CategoryCard(props) {
  const [category, setCategory] = useState([]);
  //   useEffect(async () => {
  //     const result = await axios(
  //       window.location.origin + "/api/transactions/category"
  //     );

  //     setCategory(result.data);
  //     return ;
  //   }, []);

  var score1 = data[0].percentage;
  var score2 = data[1].percentage;
  var score3 = data[2].percentage;
  var score4 = data[3].percentage;

  console.log(score1);

  return (
    <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg h-72">
      <div class="flex" style={{ width: 1220, height: 170 }}>
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? score1 : score1;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage + "%"}
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
            const percentage = isVisible ? score2 : score2;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage + "%"}
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
            const percentage = isVisible ? score3 : score3;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage + "%"}
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
            const percentage = isVisible ? score4 : score4;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage + "%"}
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
        <p>Food: {data[0].amountInKg} kilograms</p>
        <p>Shopping: {data[1].amountInKg} kilograms</p>
        <p>Entertainment: {data[2].amountInKg} kilograms</p>
        <p>Transportation: {data[3].amountInKg} kilograms </p>
      </div>
    </div>
  );
}

export default CategoryCard;
