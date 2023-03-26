import Navbar from "../../components/Navbar";
import { CircularProgressbar } from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';

function Calculator() {

    const percentage = 66;

    return (
        <div style={{ width: 150, height: 100 }}>
            <CircularProgressbar value={55} />
            <CircularProgressbar value={66} />
            <CircularProgressbar value={86} />
            
        </div>
    )
}

export default Calculator;