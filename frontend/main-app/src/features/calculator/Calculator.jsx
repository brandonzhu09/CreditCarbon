import Navbar from "../../components/Navbar";
import OverviewCard from "../../components/OverviewCard";
import CategoryCard from "../../components/CategoryCard";

function Calculator() {

    const percentage = 66;

    return (
        <div>
            <Navbar />
            <div class="m-4">
                <h1 class="font-bold text-3xl">Dashboard</h1>
                <OverviewCard />
                <h1 class="font-bold text-3xl">Categories</h1>
                <CategoryCard />
            </div>
        </div>
    )
}

export default Calculator;