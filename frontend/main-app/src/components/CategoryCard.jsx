import { CircularProgressbar } from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';

function CategoryCard(props) {
    return (
        <div class="bg-gray-100 my-4 rounded p-5 max-w-full overflow-hidden shadow-lg transition ease-in-out delay-150 hover:scale-105 duration-300 h-72">

            <div class="flex" style={{ width: 1250, height: 170}}>
                <CircularProgressbar value={86} />
                <CircularProgressbar value={86} />
                <CircularProgressbar value={86} />
                <CircularProgressbar value={86} />
                {/* <div class="flex justify-center">
                    <CircularProgressbar value={55} />
                    <CircularProgressbar value={66} />
                </div>
                <div class="flex-grow max-w-full justify-center">
                    <CircularProgressbar value={86} />
                    <CircularProgressbar value={86} />
                </div> */}
            </div>
 
            
        </div>
    )
}

export default CategoryCard;