import { buildStyles, CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import VisibilitySensor from "react-visibility-sensor";

function ProgressBar(props) {
  var score = props.score;
  var pathColor = props.pathColor;
  var textColor = props.textColor;

  return (
    <div>
      {
        <VisibilitySensor>
          {({ isVisible }) => {
            const percentage = isVisible ? { score } : 0;
            return (
              <CircularProgressbar
                value={percentage}
                text={percentage}
                styles={{
                  path: {
                    stroke: { pathColor },
                    strokeLinecap: "butt",
                  },
                  text: {
                    fill: { textColor },
                  },
                }}
              />
            );
          }}
        </VisibilitySensor>
      }
    </div>
  );
}

export default ProgressBar;
